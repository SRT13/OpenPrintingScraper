package it.mankey.lps.core;

import it.mankey.lps.TestConstants;
import it.mankey.lps.domain.Fixtures;
import it.mankey.lps.domain.Manifacturer;
import it.mankey.lps.domain.Printer;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @since 08-09-2012 09:48
 */
public class OpenPrintingScraperIT {

    private final OpenPrintingScraper openPrintingScraper;

    public OpenPrintingScraperIT() throws IOException {
        openPrintingScraper = OpenPrintingScraper.create();
    }

    @Test
    public void scraperShouldFindManifacturers() throws IOException {
        final List<Manifacturer> manifacturers = openPrintingScraper.getManifacturers();
        Assert.assertTrue(!manifacturers.isEmpty());
        Assert.assertTrue(manifacturers.containsAll(Fixtures.WELL_KNOWN_MANIFACTURERS));
    }

    @Test
    public void getPrinterByBrand() throws IOException {
        final List<Printer> printers = openPrintingScraper.getPrinters(Manifacturer.create(TestConstants.WELL_KNOWN_BRAND));
        Assert.assertTrue(!printers.isEmpty());
    }
}
