package br.com.mind5.model.decisionTree.common;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeAdapter;


//TODO: Realmente necessario ?
public final class DeciTreeDummy<T> implements DeciTree<T> {
	private DeciResultHelper<T> dummyResult;
	private List<T> dummyResultset;	
	
	
	public DeciTreeDummy(List<T> dummyRecords) {
		checkArgument(dummyRecords);
		dummyResultset = dummyRecords;
		
		buildDummyResult();
	}
	
	
	
	private void checkArgument(List<T> dummyRecords) {
		if (dummyRecords == null) {
			logException(new NullPointerException("dummyRecords" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("dummyRecords" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void buildDummyResult() {
		dummyResult = new DeciResultHelper<>();
		
		dummyResult.resultset = dummyResultset;
		dummyResult.isSuccess = true;
		dummyResult.hasResultset = true;
	}
	
	
	
	@Override public void makeDecision() {
		//Do nothing
	}

	
	
	@Override public DeciResult<T> getDecisionResult() {
		return dummyResult;
	}

	
	
	@Override public ActionStd<T> toAction() {
		return new DeciTreeAdapter<>(this);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
