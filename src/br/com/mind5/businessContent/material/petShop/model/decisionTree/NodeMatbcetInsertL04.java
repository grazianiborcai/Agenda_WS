package br.com.mind5.businessContent.material.petShop.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.businessContent.material.petShop.info.MatbcetInfo;
import br.com.mind5.businessContent.material.petShop.model.action.LazyMatbcetMatInsert;
import br.com.mind5.businessContent.material.petShop.model.action.LazyMatbcetNodeInsertL05;
import br.com.mind5.businessContent.material.petShop.model.action.StdMatbcetEnforceCatHaircut;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeMatbcetInsertL04 extends DeciTreeTemplateWriteV2<MatbcetInfo> {
	
	public NodeMatbcetInsertL04(DeciTreeOption<MatbcetInfo> option) {
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
		
		ActionStdV1<MatbcetInfo> enforceCatHaircut = new StdMatbcetEnforceCatHaircut(option);	
		ActionLazyV1<MatbcetInfo> insertMat = new LazyMatbcetMatInsert(option.conn, option.schemaName);	
		ActionLazyV1<MatbcetInfo> nodeL05 = new LazyMatbcetNodeInsertL05(option.conn, option.schemaName);
		
		enforceCatHaircut.addPostAction(insertMat);
		insertMat.addPostAction(nodeL05);
		
		actions.add(enforceCatHaircut);		
		return actions;
	}
}
