package br.com.mind5.businessContent.material.petShop.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.businessContent.material.petShop.info.MatbcetInfo;
import br.com.mind5.businessContent.material.petShop.model.action.LazyMatbcetMatInsert;
import br.com.mind5.businessContent.material.petShop.model.action.LazyMatbcetNodeInsertL06;
import br.com.mind5.businessContent.material.petShop.model.action.StdMatbcetEnforceDogHaircutScissor;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeMatbcetInsertL05 extends DeciTreeTemplateWriteV2<MatbcetInfo> {
	
	public NodeMatbcetInsertL05(DeciTreeOption<MatbcetInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatbcetInfo> buildCheckerHook(DeciTreeOption<MatbcetInfo> option) {
		List<ModelCheckerV1<MatbcetInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatbcetInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<MatbcetInfo>> buildActionsOnPassedHook(DeciTreeOption<MatbcetInfo> option) {
		List<ActionStdV2<MatbcetInfo>> actions = new ArrayList<>();		
		
		ActionStdV2<MatbcetInfo> enforceDogHaircutScissor = new StdMatbcetEnforceDogHaircutScissor(option);	
		ActionLazy<MatbcetInfo> insertMat = new LazyMatbcetMatInsert(option.conn, option.schemaName);	
		ActionLazy<MatbcetInfo> nodeL06 = new LazyMatbcetNodeInsertL06(option.conn, option.schemaName);
		
		enforceDogHaircutScissor.addPostAction(insertMat);
		insertMat.addPostAction(nodeL06);
		
		actions.add(enforceDogHaircutScissor);		
		return actions;
	}
}
