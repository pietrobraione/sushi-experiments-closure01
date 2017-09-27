package settings;

import static settings.Settings.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import sushi.configure.Coverage;
import sushi.configure.JBSEParameters;
import sushi.configure.MergerParameters;
import sushi.configure.Options;
import sushi.configure.ParametersModifier;
import sushi.configure.ParseException;
import sushi.logging.Level;

public class Closure01ParametersAccurate extends ParametersModifier {
	@Override
	public void modify(Options p) {
		p.setLogLevel(Level.DEBUG);

		//Local configurations
		p.setEvosuitePath(EVOSUITE_PATH);
		p.setSushiLibPath(SUSHI_LIB_PATH);
		p.setZ3Path(Z3_PATH);

		//Target 
		p.setClassesPath(BIN_PATH, GUAVA_PATH, RHINO_PATH, JBSE_PATH);
		p.setJREPath(JRE_PATH);
		p.setTargetMethod("com/google/javascript/jscomp/AnalysisDriver", "(Lcom/google/javascript/rhino/Node;ZZZ)V", "driver_RemoveUnusedVars_process");

		//Analysis params 
		p.setJBSEBudget(3600);
		p.setEvosuiteBudget(3600);
		p.setCoverage(Coverage.BRANCHES);
		p.setPhases(1, 2, 3, 4, 5, 6);
		
		//Tmp out directories
		p.setOutDirectory(OUT_PATH);
		p.setTmpDirectoryBase(TMP_BASE_PATH);
		
		//Parallelism
		p.setRedundanceEvosuite(1);
		p.setParallelismEvosuite(2);
		
		//Timeout
		p.setGlobalBudget(7200);
	}

	@Override
	public void modify(JBSEParameters p) 
	throws FileNotFoundException, ParseException, IOException {
		loadHEXFile(SETTINGS_PATH + "closure_compiler_accurate.jbse", p);
		
		p.setHeapScope("com/google/javascript/rhino/Node", 4);		
		p.setHeapScope("com/google/javascript/rhino/Node$StringNode", 2);		

		p.setDepthScope(200);
		p.setCountScope(6000);
	}	
	
	@Override
	public void modify(MergerParameters p) {
		p.setBranchesToCover("com/google/javascript/jscomp/RemoveUnusedVars.*");
	}


	@Override
	public void modify(List<String> p) {
		p.add("-Dobject_reuse_probability=0.8");
		p.add("-Delite=5");
	}
}
