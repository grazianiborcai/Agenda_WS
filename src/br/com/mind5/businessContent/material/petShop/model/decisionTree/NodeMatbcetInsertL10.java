package br.com.mind5.businessContent.material.petShop.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.businessContent.material.petShop.info.MatbcetInfo;
import br.com.mind5.businessContent.material.petShop.model.action.LazyMatbcetMatInsert;
import br.com.mind5.businessContent.material.petShop.model.action.StdMatbcetEnforceCatHydration;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeMatbcetInsertL10 extends DeciTreeTemplateWriteV2<MatbcetInfo> {
	
	public NodeMatbcetInsertL10(DeciTreeOption<MatbcetInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatbcetInfo> buildCheckerHook(DeciTreeOption<MatbcetInfo> option) {
		List<ModelCheckerV1<MatbcetInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatbcetInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatbcetInfo>> buildActionsOnPassedHook(DeciTreeOption<MatbcetInfo> option) {
		List<ActionStdV1<MatbcetInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<MatbcetInfo> enforceCatHydration = new StdMatbcetEnforceCatHydration(option);	
		ActionLazy<MatbcetInfo> insertMat = new LazyMatbcetMatInsert(option.conn, option.schemaName);	
		
		enforceCatHydration.addPostAction(insertMat);
		
		actions.add(enforceCatHydration);		
		return actions;
	}
}
