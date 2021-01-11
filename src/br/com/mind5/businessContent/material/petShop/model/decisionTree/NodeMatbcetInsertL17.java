package br.com.mind5.businessContent.material.petShop.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.businessContent.material.petShop.info.MatbcetInfo;
import br.com.mind5.businessContent.material.petShop.model.action.LazyMatbcetMatInsert;
import br.com.mind5.businessContent.material.petShop.model.action.LazyMatbcetNodeInsertL18;
import br.com.mind5.businessContent.material.petShop.model.action.StdMatbcetEnforceDogVaccineV10;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeMatbcetInsertL17 extends DeciTreeTemplateWrite<MatbcetInfo> {
	
	public NodeMatbcetInsertL17(DeciTreeOption<MatbcetInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatbcetInfo> buildCheckerHook(DeciTreeOption<MatbcetInfo> option) {
		List<ModelChecker<MatbcetInfo>> queue = new ArrayList<>();		
		ModelChecker<MatbcetInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatbcetInfo>> buildActionsOnPassedHook(DeciTreeOption<MatbcetInfo> option) {
		List<ActionStd<MatbcetInfo>> actions = new ArrayList<>();		
		
		ActionStd<MatbcetInfo> enforceDogVaccineV10 = new StdMatbcetEnforceDogVaccineV10(option);	
		ActionLazy<MatbcetInfo> insertMat = new LazyMatbcetMatInsert(option.conn, option.schemaName);	
		ActionLazy<MatbcetInfo> nodeL18 = new LazyMatbcetNodeInsertL18(option.conn, option.schemaName);
		
		enforceDogVaccineV10.addPostAction(insertMat);
		insertMat.addPostAction(nodeL18);
		
		actions.add(enforceDogVaccineV10);		
		return actions;
	}
}
