package br.com.mind5.business.materialList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialList.model.action.StdMatlisMergeSytotauh;
import br.com.mind5.business.materialList.model.action.StdMatlisSuccess;
import br.com.mind5.business.materialList.model.checker.MatlisCheckAuthCustomer;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class NodeMatlisAuth extends DeciTreeTemplateRead<MatlisInfo> {
	
	public NodeMatlisAuth(DeciTreeOption<MatlisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatlisInfo> buildCheckerHook(DeciTreeOption<MatlisInfo> option) {
		List<ModelChecker<MatlisInfo>> queue = new ArrayList<>();		
		ModelChecker<MatlisInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatlisCheckAuthCustomer(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatlisInfo>> buildActionsOnPassedHook(DeciTreeOption<MatlisInfo> option) {
		List<ActionStd<MatlisInfo>> actions = new ArrayList<>();
		
		ActionStd<MatlisInfo> success = new StdMatlisSuccess(option);

		actions.add(success);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<MatlisInfo>> buildActionsOnFailedHook(DeciTreeOption<MatlisInfo> option) {
		List<ActionStd<MatlisInfo>> actions = new ArrayList<>();
		
		ActionStd<MatlisInfo> mergeSytotauh = new StdMatlisMergeSytotauh(option);
		
		actions.add(mergeSytotauh);
		return actions;
	}
}
