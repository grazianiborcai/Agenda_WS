package br.com.gda.model.decisionTree.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public abstract class DeciTreeTemplate<T> implements DeciTree<T> {
	private DeciTree<T> helper;
	private DeciTreeOption<T> option;
	
	
	public DeciTreeTemplate(T recordInfo) {
		this(recordToList(recordInfo));
	}
	
	
	
	private static <T> List<T> recordToList(T recordInfo) {
		List<T> recordInfos = new ArrayList<>();
		recordInfos.add(recordInfo);
		return recordInfos;
	}
	
	
	
	public DeciTreeTemplate(List<T> recordInfos) {
		checkArgument(recordInfos);
		init(recordInfos);
	}
	
	
	
	private void checkArgument(List<T> recordInfos) {
		if (recordInfos == null) {
			logException(new IllegalArgumentException("recordInfos" + SystemMessage.NULL_ARGUMENT));
			throw new IllegalArgumentException("recordInfos" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (recordInfos.isEmpty()) {
			logException(new IllegalArgumentException("recordInfos" + SystemMessage.EMPTY_ARGUMENT));
			throw new IllegalArgumentException("recordInfos" + SystemMessage.EMPTY_ARGUMENT);
		}		
	}
	
	
	
	private void init(List<T> recordInfos) {
		option = initOption(recordInfos);
		helper = initHelper(option);
	}
	
	
	
	private DeciTreeOption<T> initOption(List<T> recordInfos) {
		DeciTreeOption<T> optionTree = new DeciTreeOption<>();
		
		optionTree.recordInfos = recordInfos;
		optionTree.conn = DbConnection.getConnection();
		optionTree.schemaName = DbSchema.getDefaultSchemaName();
		
		return optionTree;
	}
	
	
	
	private DeciTree<T> initHelper(DeciTreeOption<T> optionTree) {
		return getTreeHook(optionTree);
	}
	
	
	
	protected DeciTree<T> getTreeHook(DeciTreeOption<T> optionTree) {
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	@Override public void makeDecision() {
		helper.makeDecision();
	}	
	
	
	
	@Override public DeciChoice getDecisionMade(){
		return helper.getDecisionMade();
	}	
	
	
	
	@Override public DeciResult<T> getDecisionResult() {
		return helper.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<T> toAction() {
		return helper.toAction();
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
