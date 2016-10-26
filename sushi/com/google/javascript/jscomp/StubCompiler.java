package com.google.javascript.jscomp;

import java.util.List;
import java.util.Map;

import com.google.common.base.Supplier;
import com.google.javascript.jscomp.AbstractCompiler;
import com.google.javascript.jscomp.CodeChangeHandler;
import com.google.javascript.jscomp.CodingConvention;
import com.google.javascript.jscomp.CompilerInput;
import com.google.javascript.jscomp.CompilerPass;
import com.google.javascript.jscomp.CssRenamingMap;
import com.google.javascript.jscomp.ErrorManager;
import com.google.javascript.jscomp.GlobalVarReferenceMap;
import com.google.javascript.jscomp.JSError;
import com.google.javascript.jscomp.JSModule;
import com.google.javascript.jscomp.JSModuleGraph;
import com.google.javascript.jscomp.ReferenceCollectingCallback.ReferenceCollection;
import com.google.javascript.jscomp.Region;
import com.google.javascript.jscomp.Scope;
import com.google.javascript.jscomp.Scope.Var;
import com.google.javascript.jscomp.ScopeCreator;
import com.google.javascript.jscomp.SourceFile;
import com.google.javascript.jscomp.TypeValidator;
import com.google.javascript.jscomp.parsing.Config;
import com.google.javascript.jscomp.type.ReverseAbstractInterpreter;
import com.google.javascript.rhino.InputId;
import com.google.javascript.rhino.Node;
import com.google.javascript.rhino.head.ErrorReporter;
import com.google.javascript.rhino.head.ast.AstRoot;
import com.google.javascript.rhino.jstype.JSTypeRegistry;


public class StubCompiler extends AbstractCompiler{

	@Override
	public String getSourceLine(String sourceName, int lineNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	LifeCycleStage getLifeCycleStage() {
		return LifeCycleStage.NORMALIZED;
	}

	@Override
	public Region getSourceRegion(String sourceName, int lineNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompilerInput getInput(InputId inputId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	SourceFile getSourceFileByName(String sourceName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	CompilerInput newExternInput(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	JSModuleGraph getModuleGraph() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	List<CompilerInput> getInputsInOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSTypeRegistry getTypeRegistry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	ScopeCreator getTypedScopeCreator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Scope getTopScope() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void report(JSError error) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void throwInternalError(String msg, Exception cause) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CodingConvention getCodingConvention() {
		return new ClosureCodingConvention();
	}

	@Override
	public void reportCodeChange() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void addToDebugLog(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void setCssRenamingMap(CssRenamingMap map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	CssRenamingMap getCssRenamingMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Node getNodeForCodeInsertion(JSModule module) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	TypeValidator getTypeValidator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Node parseSyntheticCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Node parseSyntheticCode(String filename, String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Node parseTestCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	String toSource(Node root) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	ErrorReporter getDefaultErrorReporter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReverseAbstractInterpreter getReverseAbstractInterpreter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Supplier<String> getUniqueNameIdSupplier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	boolean hasHaltingErrors() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	void addChangeHandler(CodeChangeHandler handler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void removeChangeHandler(CodeChangeHandler handler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	boolean isIdeMode() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean acceptEcmaScript5() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean acceptConstKeyword() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	Config getParserConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	boolean isTypeCheckingEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	void prepareAst(Node root) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ErrorManager getErrorManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	boolean areNodesEqualForInlining(Node n1, Node n2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	void setHasRegExpGlobalReferences(boolean references) {
		// TODO Auto-generated method stub
		
	}

	@Override
	boolean hasRegExpGlobalReferences() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	CheckLevel getErrorLevel(JSError error) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void process(CompilerPass pass) {
		// TODO Auto-generated method stub
		
	}

	@Override
	Node getRoot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void updateGlobalVarReferences(Map<Var, ReferenceCollection> refMapPatch,
			Node collectionRoot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	GlobalVarReferenceMap getGlobalVarReferences() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	CompilerInput getSynthesizedExternsInput() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getProgress() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	String getLastPassName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void setProgress(double progress, String lastPassName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	Node ensureLibraryInjected(String resourceName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void setOldParseTree(String sourceName, AstRoot astRoot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	AstRoot getOldParseTreeByName(String sourceName) {
		// TODO Auto-generated method stub
		return null;
	}
	
}