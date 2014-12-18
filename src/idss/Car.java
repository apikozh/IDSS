/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idss;

/**
 *
 * @author Andrew
 */
public class Car {
    double maxSpeed; // m/s
    double fuelCons, fuelConsLight;
    //double acceleration;

    public double getFuelCons() {
        return fuelCons;
    }

    public void setFuelCons(double fuelCons) {
        this.fuelCons = fuelCons;
    }

    public double getFuelConsLight() {
        return fuelConsLight;
    }

    public void setFuelConsLight(double fuelConsLight) {
        this.fuelConsLight = fuelConsLight;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    
    
}
