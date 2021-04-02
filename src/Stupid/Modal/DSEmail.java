/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stupid.Modal;

/**
 *
 * @author A
 */
public class DSEmail {
    private String hovaten;
    private String email;

    public DSEmail(String hovaten, String email) {
        this.hovaten = hovaten;
        this.email = email;
    }

    public DSEmail() {
    }

    public String getHovaten() {
        return hovaten;
    }

    public void setHovaten(String hovaten) {
        this.hovaten = hovaten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
