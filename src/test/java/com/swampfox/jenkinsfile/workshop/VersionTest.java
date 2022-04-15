package com.swampfox.jenkinsfile.workshop;

import com.swampfox.jenkinsfile.workshop.data.Version;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VersionTest {
    @Test
    public void ensureVersionMatches() {
        Version v = new Version();
        assertEquals("1.0.0", v.getCurrentVersion());
    }
}
