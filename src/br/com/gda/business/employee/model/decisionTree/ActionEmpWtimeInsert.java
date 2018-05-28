package br.com.gda.business.employee.model.decisionTree;

import br.com.gda.business.employee.info.EmpWTimeInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionEmpWtimeInsert implements DeciAction<EmpWTimeInfo> {
	private DeciTree<EmpWTimeInfo> forwardTree;
	
	
	public ActionEmpWtimeInsert(DeciTreeOption<EmpWTimeInfo> option) {
		forwardTree = new NodeEmpWtimeInsert(option);
	}
	
	
	
	@Override public boolean executeAction() {
		forwardTree.makeDecision();
		return forwardTree.getDecisionResult().hasSuccessfullyFinished();
	}	
	
	
	
	@Override public DeciResult<EmpWTimeInfo> getDecisionResult() {
		return forwardTree.getDecisionResult();
	}
}
