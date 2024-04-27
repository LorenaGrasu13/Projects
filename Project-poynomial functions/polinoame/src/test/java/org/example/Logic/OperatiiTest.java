package org.example.Logic;

import org.example.Model.Polinom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatiiTest {

    Polinom p1 = new Polinom("3x^2+8x^7+4");
    Polinom p2 = new Polinom("4x^3-3x^1+5");
    @Test
    void adunare() {
        assertEquals("9.0-3.0x^1  + 3.0x^2  + 4.0x^3  + 8.0x^7 ",Operatii.adunare(p1,p2).afis());
    }

    @Test
    void scadere() {
        assertEquals("-1.0 + 3.0x^1  + 3.0x^2 -4.0x^3  + 8.0x^7 ",Operatii.scadere(p1,p2).afis());
    }

    @Test
    void inmultire() {
        assertEquals("20.0-12.0x^1  + 15.0x^2  + 7.0x^3  + 12.0x^5  + 40.0x^7 -24.0x^8  + 32.0x^10 ",Operatii.inmultire(p1,p2).afis());
    }

    @Test
    void derivare() {
        assertEquals("0.0 + 6.0x^1  + 56.0x^6 ",Operatii.derivare(p1).afis());
    }

    @Test
    void integrare() {
        assertEquals(" + 4.0x^1  + 1.0x^3  + 1.0x^8 ",Operatii.integrare(p1).afis());
    }
}