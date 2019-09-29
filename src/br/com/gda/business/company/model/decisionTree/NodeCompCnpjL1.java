package br.com.gda.business.company.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.company.model.action.StdCompSuccess;
import br.com.gda.business.company.model.checker.CompCheckHasCnpj;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class NodeCompCnpjL1 extends DeciTreeWriteTemplate<CompInfo> {
	
	public NodeCompCnpjL1(DeciTreeOption<CompInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CompInfo> buildDecisionCheckerHook(DeciTreeOption<CompInfo> option) {
		List<ModelChecker<CompInfo>> queue = new ArrayList<>();		
		ModelChecker<CompInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new CompCheckHasCnpj(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CompInfo>> buildActionsOnPassedHook(DeciTreeOption<CompInfo> option) {
		List<ActionStd<CompInfo>> actions = new ArrayList<>();
		
		ActionStd<CompInfo> nodeCnpjL2 = new NodeCompCnpjL2(option).toAction();		
		actions.add(nodeCnpjL2);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CompInfo>> buildActionsOnFailedHook(DeciTreeOption<CompInfo> option) {
		List<ActionStd<CompInfo>> actions = new ArrayList<>();
		
		ActionStd<CompInfo> success = new StdCompSuccess(option);
		actions.add(success);	
		return actions;
	}
}
