package br.com.mind5.businessContent.material.petShop.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.businessContent.material.petShop.info.MatbcetInfo;
import br.com.mind5.businessContent.material.petShop.model.action.LazyMatbcetMatInsert;
import br.com.mind5.businessContent.material.petShop.model.action.LazyMatbcetNodeInsertL19;
import br.com.mind5.businessContent.material.petShop.model.action.StdMatbcetEnforceDogVaccineV8;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeMatbcetInsertL18 extends DeciTreeTemplateWrite<MatbcetInfo> {
	
	public NodeMatbcetInsertL18(DeciTreeOption<MatbcetInfo> option) {
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
		
		ActionStd<MatbcetInfo> enforceDogVaccineV8 = new StdMatbcetEnforceDogVaccineV8(option);	
		ActionLazy<MatbcetInfo> insertMat = new LazyMatbcetMatInsert(option.conn, option.schemaName);
		ActionLazy<MatbcetInfo> nodeL19 = new LazyMatbcetNodeInsertL19(option.conn, option.schemaName);
		
		enforceDogVaccineV8.addPostAction(insertMat);
		insertMat.addPostAction(nodeL19);
		
		actions.add(enforceDogVaccineV8);		
		return actions;
	}
}
