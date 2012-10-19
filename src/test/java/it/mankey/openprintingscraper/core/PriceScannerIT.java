package it.mankey.openprintingscraper.core;

import it.mankey.openprintingscraper.TestConstants;
import it.mankey.openprintingscraper.domain.Country;
import it.mankey.openprintingscraper.domain.Manufacturer;
import it.mankey.openprintingscraper.domain.Printer;
import it.mankey.openprintingscraper.domain.Quote;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * @since 08-09-2012 20:45
 */
public class PriceScannerIT {

    private final PriceScanner priceScanner;

    public PriceScannerIT() throws MalformedURLException {
        final URL apiUrl = new URL("https://www.googleapis.com");
        priceScanner = new PriceScanner(apiUrl, "AIzaSyA-HWMPuwbZ4aSpDfw2xjOMn4L_eObiMLM");
    }

    @Test
    public void testGetQuotes() throws Exception {
        final Printer testPrinter = Printer.create(Manufacturer.create(TestConstants.WELL_KNOWN_BRAND), "Color LaserJet 5550");
        final List<Quote> quotations = priceScanner.getQuotes(testPrinter, Country.Alpha2.GB);
        Assert.assertTrue(!quotations.isEmpty());
    }
}
