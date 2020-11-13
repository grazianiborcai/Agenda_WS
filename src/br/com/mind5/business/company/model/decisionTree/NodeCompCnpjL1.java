package br.com.mind5.business.company.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.model.action.StdCompSuccess;
import br.com.mind5.business.company.model.checker.CompCheckHasCnpj;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeCompCnpjL1 extends DeciTreeTemplateWriteV2<CompInfo> {
	
	public NodeCompCnpjL1(DeciTreeOption<CompInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CompInfo> buildCheckerHook(DeciTreeOption<CompInfo> option) {
		List<ModelCheckerV1<CompInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CompInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new CompCheckHasCnpj(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<CompInfo>> buildActionsOnPassedHook(DeciTreeOption<CompInfo> option) {
		List<ActionStdV2<CompInfo>> actions = new ArrayList<>();
		
		ActionStdV2<CompInfo> nodeL2 = new NodeCompCnpjL2(option).toAction();	
		
		actions.add(nodeL2);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<CompInfo>> buildActionsOnFailedHook(DeciTreeOption<CompInfo> option) {
		List<ActionStdV2<CompInfo>> actions = new ArrayList<>();
		
		ActionStdV2<CompInfo> success = new StdCompSuccess(option);
		
		actions.add(success);	
		return actions;
	}
}
