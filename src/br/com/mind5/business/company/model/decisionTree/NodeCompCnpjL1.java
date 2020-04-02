package br.com.mind5.business.company.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.model.action.StdCompSuccess;
import br.com.mind5.business.company.model.checker.CompCheckHasCnpj;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

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
	
	
	
	@Override protected List<ActionStdV1<CompInfo>> buildActionsOnPassedHook(DeciTreeOption<CompInfo> option) {
		List<ActionStdV1<CompInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CompInfo> nodeCnpjL2 = new NodeCompCnpjL2(option).toAction();		
		actions.add(nodeCnpjL2);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<CompInfo>> buildActionsOnFailedHook(DeciTreeOption<CompInfo> option) {
		List<ActionStdV1<CompInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CompInfo> success = new StdCompSuccess(option);
		actions.add(success);	
		return actions;
	}
}
