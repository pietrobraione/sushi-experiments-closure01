package settings;

import static settings.Settings.BIN_PATH;
import static settings.Settings.GUAVA_PATH;
import static settings.Settings.JBSE_PATH;
import static settings.Settings.RHINO_PATH;
import static settings.Settings.SETTINGS_PATH;
import static settings.Settings.TMP_BASE_PATH;
import static settings.Settings.Z3_PATH;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

import jbse.apps.run.RunParameters;
import jbse.apps.run.Run;
import jbse.apps.run.RunParameters.DecisionProcedureType;
import jbse.apps.run.RunParameters.StateFormatMode;
import jbse.apps.run.RunParameters.StepShowMode;
import jbse.apps.settings.SettingsReader;
import sushi.configure.ParseException;

public class RunClosure01 {
    public static void main(String[] args) throws FileNotFoundException, ParseException, IOException	{
        RunParameters p = new RunParameters();
        set(p);
        Run r = new Run(p);
        r.run();
    }

    private static final String METHOD_CLASS      = "com/google/javascript/jscomp/AnalysisDriver"; 
    private static final String METHOD_DESCRIPTOR = "(Lcom/google/javascript/rhino/Node;ZZZ)V"; 
    private static final String METHOD_NAME       = "driver_RemoveUnusedVars_process"; 
    private static final Path   OUT_FILE          = TMP_BASE_PATH.resolve("runClosure01.txt");

    private static void set(RunParameters p) throws ParseException, IOException {
    	loadHEXFile(SETTINGS_PATH.resolve("closure_compiler_accurate.jbse"), p);
        p.addUserClasspath(BIN_PATH, GUAVA_PATH, RHINO_PATH, JBSE_PATH);
        p.setMethodSignature(METHOD_CLASS, METHOD_DESCRIPTOR, METHOD_NAME);
        p.setOutputFileName(OUT_FILE.toString());
        p.setDecisionProcedureType(DecisionProcedureType.Z3);
        p.setExternalDecisionProcedurePath(Z3_PATH);
        p.setShowDecisionProcedureInteraction(false);
        p.setShowWarnings(true);
        p.setStepShowMode(StepShowMode.LEAVES);
        p.setStateFormatMode(StateFormatMode.TRACE);
		p.setHeapScope("com/google/javascript/rhino/Node", 4);		
		p.setHeapScope("com/google/javascript/rhino/Node$StringNode", 2);		
		p.setDepthScope(200);
		p.setCountScope(6000);
		p.setTimeout(1, TimeUnit.HOURS);
    }
    
	private static void loadHEXFile(Path path, RunParameters p) 
	throws ParseException, IOException {
		final SettingsReader sr;
		try {
			sr = new SettingsReader(path);
		} catch (jbse.apps.settings.ParseException e) {
			throw new ParseException("File " + path + ": " + e.getMessage());
		}
		sr.fillRunnerParameters(p.getRunnerParameters());
		sr.fillRulesLICS(p.getLICSRulesRepo());
		sr.fillRulesClassInit(p.getClassInitRulesRepo());
	}
	
}
