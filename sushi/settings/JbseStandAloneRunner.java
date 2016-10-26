package settings;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import jbse.apps.run.Run;
import jbse.apps.run.RunParameters;
import jbse.apps.run.RunParameters.DecisionProcedureType;
import jbse.apps.run.RunParameters.StateFormatMode;
import jbse.apps.run.RunParameters.StepShowMode;
import jbse.apps.settings.ParseException;
import jbse.jvm.EngineParameters.BreadthMode;
import jbse.jvm.EngineParameters.StateIdentificationMode;

public class JbseStandAloneRunner {
	public static void main(String[] args) throws FileNotFoundException, ParseException, IOException {
		//prepares the parameters
		final RunParameters p = new RunParameters();
		
		//JBSE configuration
		p.addClasspath(Paths.get("..", "sushi-experiments-closure01", "build/classes").toString(),
				Paths.get("..", "sushi-experiments-closure01", "lib/guava.jar").toString(),
				"/Users/denaro/git/jbse-new/data/jre/rt.jar",
				"/Users/denaro/git/jbse-new/bin/");
		p.setDecisionProcedureType(DecisionProcedureType.Z3);
		p.setExternalDecisionProcedurePath("/Users/denaro/Desktop/RTools/Z3/z3-4.3.2.d548c51a984e-x64-osx-10.8.5/bin/z3");
		p.setOutputFileName(Paths.get("..", "sushi-experiments-closure01", "out") + "/closure01.jbse.txt");

		
		//Analysis configuration
		p.setMethodSignature("com/google/javascript/jscomp/AnalysisDriver", "(Lcom/google/javascript/rhino/Node;ZZZ)V", "driver_RemoveUnusedVars_process");

		Closure01Parameters expParams = new Closure01Parameters();
		//expParams.modify(p);//TODO
		
		//Internal settings as in sushi
		//p.setStateIdentificationMode(StateIdentificationMode.LONG);
		p.setTimeout(4, TimeUnit.HOURS);
		//p.setIdentifierSubregion(".1.1.1.1.3.5.8.1.3.5.11.2.3.2.2.3.1.2.2");

		//what to show
		p.setStepShowMode(StepShowMode.LEAVES);
		p.setStateFormatMode(StateFormatMode.TRACE);
		p.setShowWarnings(true);

		p.setShowSafe(true);
		p.setShowUnsafe(true);
		p.setShowOutOfScope(false);
		p.setShowContradictory(false);
		p.setShowDecisionProcedureInteraction(false);	
		
		//executes JBSE
		final Run r = new Run(p);
		r.run();
	}
}
