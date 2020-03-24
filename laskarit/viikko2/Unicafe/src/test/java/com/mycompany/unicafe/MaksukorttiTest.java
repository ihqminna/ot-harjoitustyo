package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(1000);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void kortinSaldoAlussaOikein(){
        assertEquals("saldo: 10.0", kortti.toString());
    }
    
    @Test
    public void rahanLataaminenToimiiOikein(){
        kortti.lataaRahaa(1555);
        assertEquals("saldo: 25.55", kortti.toString());
    }
    
    @Test
    public void kortinSaldoVahenee(){
        kortti.otaRahaa(255);
        assertEquals("saldo: 7.45", kortti.toString());
    }
    
    @Test
    public void saldoEiMuutuJosEiKatetta(){
        kortti.otaRahaa(2355);
        assertEquals("saldo: 10.0", kortti.toString());
    }
    
    @Test
    public void maksunOnnistuminenTrue(){
        assertEquals(true, kortti.otaRahaa(500));
    }
    
    @Test
    public void maksunEpaonnistuminenFalse(){
        assertEquals(false, kortti.otaRahaa(2355));
    }
    
    @Test
    public void palauttaaOikeanSaldon(){
        assertEquals(1000, kortti.saldo());
    }
}
