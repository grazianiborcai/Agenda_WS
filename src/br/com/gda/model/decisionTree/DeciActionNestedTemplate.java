package br.com.gda.model.decisionTree;

import java.lang.reflect.Constructor;
import java.util.List;

import br.com.gda.common.SystemMessage;

public abstract class DeciActionNestedTemplate<T, S> implements DeciAction<T> {
	private final boolean FAILED = false;
	private final boolean NOT_EMPTY = false;
	
	private DeciAction<S> actStarter;
	private DeciTree<S> deciTree;
	
	
	
	public DeciActionNestedTemplate(DeciTreeOption<T> option) {
		buildActionStarter(option);
		executeActionStater();
		buildDecisionTree(option);
	}
	
	
	
	private void buildActionStarter(DeciTreeOption<T> option) {
		List<S> transInfos = translateRecordInfosHook(option.recordInfos);
		DeciTreeOption<S> transOption = translateOption(option, transInfos);
		
		actStarter = getInstanceOfStarter(transOption);
	}
	
	
	
	protected List<S> translateRecordInfosHook(List<T> recordInfos) {
		//Template method to be overridden by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private DeciTreeOption<S> translateOption(DeciTreeOption<T> option, List<S> recordInfos) {
		DeciTreeOption<S> newOption = new DeciTreeOption<>();
		newOption.conn = option.conn;
		newOption.schemaName = option.schemaName;
		newOption.recordInfos = recordInfos;
		return newOption;
	}
	
	
	
	private DeciAction<S> getInstanceOfStarter(DeciTreeOption<S> option) {
		try {
			//TODO: Passar a Classe á mais seguro do que receber uma instância, mas o argumento do constructor engessa a solução. rever esse ponto.
			//TODO: Mudar a classe "DeciAction" para Abstract pode resolver o problema já que é possível definior o constructor
			Class<? extends DeciAction<S>> clazz = getClassOfStarterHook();		
			Constructor<? extends DeciAction<S>> constructor = clazz.getConstructor(DeciTreeOption.class);
			return (DeciAction<S>) constructor.newInstance(option); 
			
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	
	
	protected Class<? extends DeciAction<S>> getClassOfStarterHook() {
		//Template method to be overridden by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private void executeActionStater() {
		//TODO: se houver um erro, esse erro não é transmitido para o código cliente, ao invés é disparado um excesão. Rever esse ponto.
		if ( actStarter.executeAction() == FAILED) 
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
	}
	
	
	
	private void buildDecisionTree(DeciTreeOption<T> option) {
		List<S> recordInfos;
		DeciTreeOption<S> translatedOption;
		
		recordInfos = actStarter.getDecisionResult().getResultset();
		translatedOption = translateOption(option, recordInfos);
		
		deciTree = getInstanceOfTree(translatedOption);
	}
	
	
	
	private DeciTree<S> getInstanceOfTree(DeciTreeOption<S> option) {
		try {
			Class<? extends DeciTree<S>> clazz = getClassOfTreeHook();		
			Constructor<? extends DeciTree<S>> constructor = clazz.getConstructor(DeciTreeOption.class);
			return (DeciTree<S>) constructor.newInstance(option); 
			
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
	
	
	
	protected Class<? extends DeciTree<S>> getClassOfTreeHook() {
		//Template method to be overridden by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
		
	
	@Override public boolean executeAction() {	
		deciTree.makeDecision();
		return deciTree.getDecisionResult().hasSuccessfullyFinished();
	}
	
	
	
	@Override public DeciResult<T> getDecisionResult() {
		return translateDecisionResult(deciTree.getDecisionResult());
	}
	
	
	
	private DeciResult<T> translateDecisionResult(DeciResult<S> decisionResult) {
		DeciResultHelper<T> translatedResult = new DeciResultHelper<>();
		
		translatedResult.finishedWithSuccess = decisionResult.hasSuccessfullyFinished();
		
		if (decisionResult.hasSuccessfullyFinished() == FAILED) {
			translatedResult.failureCode = decisionResult.getFailureCode();
			translatedResult.failureMessage = decisionResult.getFailureMessage();
		}
		
		
		translatedResult.resultset = getResultsetHook(decisionResult);
		
		if (translatedResult.resultset.isEmpty() == NOT_EMPTY)
			translatedResult.hasResultset = true;		

		
		return translatedResult;
	} 
	
	
	
	protected List<T> getResultsetHook(DeciResult<S> decisionResult) {
		//Template method to be overridden by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);		
	}
}
