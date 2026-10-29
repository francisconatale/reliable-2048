package ar.edu.unrc.game2048.manual.utils;

import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.io.PrintWriter;
// imtermediate for junit 4 and 5
public class DaikonTestRunner {
    public static void main(String[] args) {
        LauncherDiscoveryRequestBuilder builder = LauncherDiscoveryRequestBuilder.request();
        for (String arg : args) {
            builder.selectors(DiscoverySelectors.selectClass(arg));
        }
        LauncherDiscoveryRequest request = builder.build();
        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);

        TestExecutionSummary summary = listener.getSummary();
        PrintWriter writer = new PrintWriter(System.out, true);
        summary.printTo(writer);
        if (summary.getTotalFailureCount() > 0) {
            summary.printFailuresTo(writer);
            writer.flush();
            System.exit(1);
        }
        writer.flush();
    }
}
