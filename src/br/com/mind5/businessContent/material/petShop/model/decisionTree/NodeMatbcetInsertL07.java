package br.com.mind5.businessContent.material.petShop.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.businessContent.material.petShop.info.MatbcetInfo;
import br.com.mind5.businessContent.material.petShop.model.action.LazyMatbcetMatInsert;
import br.com.mind5.businessContent.material.petShop.model.action.LazyMatbcetNodeInsertL08;
import br.com.mind5.businessContent.material.petShop.model.action.StdMatbcetEnforceDogHaircutClipper;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeMatbcetInsertL07 extends DeciTreeTemplateWriteV2<MatbcetInfo> {
	
	public NodeMatbcetInsertL07(DeciTreeOption<MatbcetInfo> option) {
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
		
		ActionStdV1<MatbcetInfo> enforceDogHaircutClipper = new StdMatbcetEnforceDogHaircutClipper(option);	
		ActionLazyV1<MatbcetInfo> insertMat = new LazyMatbcetMatInsert(option.conn, option.schemaName);	
		ActionLazyV1<MatbcetInfo> nodeL08 = new LazyMatbcetNodeInsertL08(option.conn, option.schemaName);
		
		enforceDogHaircutClipper.addPostAction(insertMat);
		insertMat.addPostAction(nodeL08);
		
		actions.add(enforceDogHaircutClipper);		
		return actions;
	}
}
