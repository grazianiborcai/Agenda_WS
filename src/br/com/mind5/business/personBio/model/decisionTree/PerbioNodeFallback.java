package br.com.mind5.business.personBio.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.business.personBio.model.action.PerbioVisiRootSelect;
import br.com.mind5.business.personBio.model.action.PerbioVisiMergePerbiorchEn;
import br.com.mind5.business.personBio.model.checker.PerbioCheckExist;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class PerbioNodeFallback extends DeciTreeTemplateRead<PerbioInfo> {
	
	public PerbioNodeFallback(DeciTreeOption<PerbioInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PerbioInfo> buildCheckerHook(DeciTreeOption<PerbioInfo> option) {
		List<ModelChecker<PerbioInfo>> queue = new ArrayList<>();		
		ModelChecker<PerbioInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PerbioCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PerbioInfo>> buildActionsOnPassedHook(DeciTreeOption<PerbioInfo> option) {
		List<ActionStd<PerbioInfo>> actions = new ArrayList<>();
		
		ActionStd<PerbioInfo> select = new PerbioRootSelect(option).toAction();
		
		actions.add(select);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<PerbioInfo>> buildActionsOnFailedHook(DeciTreeOption<PerbioInfo> option) {
		List<ActionStd<PerbioInfo>> actions = new ArrayList<>();
		
		ActionStd<PerbioInfo> mergePerbiorchEnglish = new ActionStdCommom<PerbioInfo>(option, PerbioVisiMergePerbiorchEn.class);
		ActionLazy<PerbioInfo> select = new ActionLazyCommom<PerbioInfo>(option, PerbioVisiRootSelect.class);
		
		mergePerbiorchEnglish.addPostAction(select);
		
		actions.add(mergePerbiorchEnglish);
		return actions;
	}
}
