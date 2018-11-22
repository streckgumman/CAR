import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarsTest {
    private final Volvo240 c1 = new Volvo240();
    private final Saab95 c2 = new Saab95();
    private final Scania c3 = new Scania();
    private final Freightliner c4 = new Freightliner();
    private final Cargoship c5 = new Cargoship();

    @org.junit.jupiter.api.Test
    void startEngine() {
        c1.startEngine();
        c1.startEngine();
        assertTrue(c1.getCurrentSpeed() == 0.1);
    }

    @org.junit.jupiter.api.Test
    void stopEngine() {
        c1.startEngine();
        c1.gas(1);
        c1.stopEngine();
        assertTrue(c1.getCurrentSpeed() == 0);
    }

    @org.junit.jupiter.api.Test
    void move() {
        c1.startEngine();
        assertEquals(0.1, c1.getCurrentSpeed());
        c1.move();
        assertEquals(0, c1.getDeg());
        assertEquals(0.1, c1.getPosX());
        assertEquals(0, c1.getPosY());

        c5.startEngine();
        assertEquals(0.1, c1.getCurrentSpeed());
        c5.move();
        assertEquals(0, c1.getDeg());
        assertEquals(0.1, c1.getPosX());
        assertEquals(0, c1.getPosY());

    }

    @org.junit.jupiter.api.Test
    void turnLeft() {
        c1.startEngine();
        c1.turnLeft();
        c1.move();
        assertEquals(1, c1.getDeg());
        assertEquals(0.099, c1.getPosX(), 0.1);
        assertEquals(0.017, c1.getPosY(), 0.1);
    }

    @org.junit.jupiter.api.Test
    void turnRight() {
        c1.turnRight();
        assertEquals(-1, c1.getDeg());
        c1.startEngine();
        c1.move();
        assertEquals(-0.017, c1.getPosY(), 0.1);
    }

    @org.junit.jupiter.api.Test
    void gas() {
        c1.startEngine();
        assertEquals(0.1, c1.getCurrentSpeed());
        c1.gas(1);
        assertEquals(1.35, c1.getCurrentSpeed());
        while (c1.getCurrentSpeed() < c1.getEnginePower()) {
            c1.gas(1);
        }
        assertEquals(c1.getCurrentSpeed(), c1.getEnginePower());

        try {
            c1.gas(5);
        } catch (Exception InvalidParameterException) {
            assert (true); } }


    @org.junit.jupiter.api.Test
    void brake() {
        c1.startEngine();
        assertTrue(c1.getCurrentSpeed() == 0.1);
        c1.brake(1);
        assertTrue(c1.getCurrentSpeed() == 0);

        try {
            c1.brake(5);
        } catch (Exception InvalidParameterException) {
            assert (true); } }

    @org.junit.jupiter.api.Test
    void setTurboOn() {
        c2.startEngine();
        assertTrue(c2.getCurrentSpeed() == 0.1);
        c2.setTurboOn();
        c2.gas(1);
        assertTrue(c2.getCurrentSpeed() == 1.725);
    }

    @org.junit.jupiter.api.Test
    void setTurboOff() {
        c2.startEngine();
        assertTrue(c2.getCurrentSpeed() == 0.1);
        c2.setTurboOn();
        c2.setTurboOff();
        assertTrue(c2.speedFactor() == 1.25);
    }

    @Test
    void tiltUp() {
        c3.tiltUp();
        assertEquals(c3.getTiltDeg(),0);
        c3.tiltDown();
        c3.tiltDown();
        c3.tiltUp();
        assertEquals(c3.getTiltDeg(),1);

        assertEquals(c4.getTiltDeg(),0);
        c4.tiltUp();
        assertEquals(c4.getTiltDeg(),0);

        c5.tiltDown();
        assertEquals(c5.getTiltDeg(),70);
        c5.tiltUp();
        assertEquals(c5.getTiltDeg(),0);

    }

    @Test
    void tiltDown() {
        assertEquals(c3.getTiltDeg(), 0);
        c3.tiltDown();
        assertEquals(c3.getTiltDeg(),1);
        c3.startEngine();
        assertEquals(c3.getTiltDeg(), 0);

        assertEquals(c4.getTiltDeg(),0);
        c4.tiltDown();
        assertEquals( c4.getTiltDeg(), 70);
        c4.tiltDown();
        assertEquals(c4.getTiltDeg(), 70);

        c5.tiltDown();
        assertEquals(c5.getTiltDeg(),70);

    }

    @Test
    void loadFreightliner() {
        assertEquals(c4.getAmountLoaded(),0);
        c4.loadCar(c1);
        assertEquals(c4.getAmountLoaded(),0);
        c4.tiltDown();
        c4.loadCar(c4);
        c4.loadCar(c1); //cant load itself or the same car multiple times
        c4.loadCar(c1);
        assertEquals(c4.getAmountLoaded(),1); // test for what happens if list is full needed
    }

    @Test
    void unloadFreightliner() {
        assertEquals(c4.getAmountLoaded(),0);
        c4.tiltDown();
        c4.unloadCar();
        assertEquals(c4.getAmountLoaded(),0);
        c4.loadCar(c1);
        c4.loadCar(c2);
        assertEquals(c4.getAmountLoaded(),2);
        c4.unloadCar();
        assertEquals(c4.getAmountLoaded(),1);
    }


    @Test
    void loadCargoship() {
        assertEquals(c5.getLoaded(),0);
        c5.loadCar(c1);
        assertEquals(c5.getLoaded(),0);
        c5.tiltDown();
        c5.loadCar(c4);
        c5.loadCar(c1); //cant load itself or the same car multiple times
        c5.loadCar(c1);
        assertEquals(c5.getLoaded(),2); // test for what happens if list is full needed
    }

    @Test
    void unloadCargoship() {
        assertEquals(c5.getLoaded(),0);
        c5.tiltDown();
        c5.unloadCar();
        assertEquals(c5.getLoaded(),0);
        c5.loadCar(c1);
        c5.loadCar(c2);
        assertEquals(c5.getLoaded(),2);
        c5.unloadCar();
        assertEquals(c5.getLoaded(),1);
    }

    @Test
    void setSamePosition(){
        c1.setSamePosition(c2);
        assertEquals(c1.getPosX(), c2.getPosX());
        assertEquals(c1.getPosY(), c2.getPosY());
    }

    @Test
    void moveWithLoad(){
        c5.loadCar(c1);
        c5.loadCar(c2);
        c5.move();
        assertEquals(c1.getPosY(), c5.getPosY());
        assertEquals(c1.getPosX(), c5.getPosX());
        assertEquals(c2.getPosY(), c5.getPosY());
        assertEquals(c2.getPosX(), c5.getPosX());
    }




}