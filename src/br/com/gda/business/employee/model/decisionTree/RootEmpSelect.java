package br.com.gda.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.action.LazyEmpMergeAddress;
import br.com.gda.business.employee.model.action.LazyEmpMergePerson;
import br.com.gda.business.employee.model.action.LazyEmpMergePhone;
import br.com.gda.business.employee.model.action.StdEmpSelect;
import br.com.gda.business.employee.model.checker.EmpCheckRead;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootEmpSelect implements DeciTree<EmpInfo> {
	private DeciTree<EmpInfo> tree;
	
	
	public RootEmpSelect(DeciTreeOption<EmpInfo> option) {
		DeciTreeHelperOption<EmpInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmpInfo> buildDecisionChecker() {
		List<ModelChecker<EmpInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpInfo> checker;
		
		checker = new EmpCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<EmpInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<EmpInfo>> buildActionsOnPassed(DeciTreeOption<EmpInfo> option) {
		List<ActionStd<EmpInfo>> actions = new ArrayList<>();
		//TODO: Incluir usuario
		ActionStd<EmpInfo> select = new StdEmpSelect(option);
		ActionLazy<EmpInfo> mergePerson = new LazyEmpMergePerson(option.conn, option.schemaName);
		ActionLazy<EmpInfo> mergeAddress = new LazyEmpMergeAddress(option.conn, option.schemaName);
		ActionLazy<EmpInfo> mergePhone = new LazyEmpMergePhone(option.conn, option.schemaName);
		//ActionLazy<EmpInfo> mergePersonUser = new LazyOwnerMergePersonUser(option.conn, option.schemaName);
		
		select.addPostAction(mergePerson);
		mergePerson.addPostAction(mergeAddress);
		mergeAddress.addPostAction(mergePhone);
		//mergePhone.addPostAction(mergePersonUser);
		
		actions.add(select);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<EmpInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
