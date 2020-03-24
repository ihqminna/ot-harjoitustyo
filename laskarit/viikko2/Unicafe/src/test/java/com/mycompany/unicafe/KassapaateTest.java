
package com.mycompany.unicafe;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class KassapaateTest {
    
    Kassapaate kassa;
    Maksukortti kortti;
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(1000);
    }
    
    @Test
    public void alkusaldotOk(){
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void edullinenKateisellaRahaRiittaa(){
        assertEquals(260, kassa.syoEdullisesti(500));
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
        assertEquals(100240, kassa.kassassaRahaa());
    }
    
    @Test
    public void maukasKateisellaRahaRiittaa(){
        assertEquals(100, kassa.syoMaukkaasti(500));
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
        assertEquals(100400, kassa.kassassaRahaa());
    }
    
    @Test
    public void edullinenKateisellaRahaEiRiita(){
        assertEquals(200, kassa.syoEdullisesti(200));
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(100000, kassa.kassassaRahaa());        
    }
    
    @Test
    public void maukasKateisellaRahaEiRiita(){
        assertEquals(300, kassa.syoMaukkaasti(300));
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void edullinenKortillaRahaa(){
        kassa.syoEdullisesti(kortti);
        assertEquals(760, kortti.saldo());
        assertEquals(1, kassa.edullisiaLounaitaMyyty());        
    }
    
    @Test
    public void edullinenKortillaEiRahaa(){
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        kassa.syoEdullisesti(kortti);
        assertEquals(200, kortti.saldo());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());        
    }
    
    @Test
    public void maukasKortillaRahaa(){
        kassa.syoMaukkaasti(kortti);
        assertEquals(600, kortti.saldo());
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void maukasKortillaEiRahaa(){
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertEquals(200, kortti.saldo());
        assertEquals(2, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kassanSaldoEiMuutuKorttiostolla(){
        kassa.syoMaukkaasti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void kortinLatausToimiiOikein(){
        kassa.lataaRahaaKortille(kortti, 2000);
        assertEquals(3000, kortti.saldo());
        assertEquals(102000, kassa.kassassaRahaa());
    }
    
    @Test
    public void kortinLatausEiOnnistuKunNegatiivinen(){
        kassa.lataaRahaaKortille(kortti, -2000);
        assertEquals(1000, kortti.saldo());
        assertEquals(100000, kassa.kassassaRahaa());        
    }
    
}
