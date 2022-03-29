package br.com.mind5.business.personBioList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personBioList.info.PerbiolisInfo;
import br.com.mind5.business.personBioList.model.action.PerbiolisVisiMergePerbioSelectFallback;
import br.com.mind5.business.personBioList.model.checker.PerbiolisCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class PerbiolisRootSelectFallback extends DeciTreeTemplateWrite<PerbiolisInfo> {
	
	public PerbiolisRootSelectFallback(DeciTreeOption<PerbiolisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PerbiolisInfo> buildCheckerHook(DeciTreeOption<PerbiolisInfo> option) {
		List<ModelChecker<PerbiolisInfo>> queue = new ArrayList<>();		
		ModelChecker<PerbiolisInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PerbiolisCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PerbiolisInfo>> buildActionsOnPassedHook(DeciTreeOption<PerbiolisInfo> option) {
		List<ActionStd<PerbiolisInfo>> actions = new ArrayList<>();
		
		ActionStd<PerbiolisInfo> mergePet = new ActionStdCommom<PerbiolisInfo>(option, PerbiolisVisiMergePerbioSelectFallback.class);
		
		actions.add(mergePet);
		return actions;
	}
}
