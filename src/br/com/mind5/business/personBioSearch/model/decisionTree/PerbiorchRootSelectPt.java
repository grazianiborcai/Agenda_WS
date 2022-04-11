package br.com.mind5.business.personBioSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personBioSearch.info.PerbiorchInfo;
import br.com.mind5.business.personBioSearch.model.action.PerbiorchVisiRootSelect;
import br.com.mind5.business.personBioSearch.model.action.PerbiorchVisiEnforcePt;
import br.com.mind5.business.personBioSearch.model.checker.PerbiorchCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class PerbiorchRootSelectPt extends DeciTreeTemplateRead<PerbiorchInfo> {
	
	public PerbiorchRootSelectPt(DeciTreeOption<PerbiorchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PerbiorchInfo> buildCheckerHook(DeciTreeOption<PerbiorchInfo> option) {
		List<ModelChecker<PerbiorchInfo>> queue = new ArrayList<>();		
		ModelChecker<PerbiorchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PerbiorchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PerbiorchInfo>> buildActionsOnPassedHook(DeciTreeOption<PerbiorchInfo> option) {
		List<ActionStd<PerbiorchInfo>> actions = new ArrayList<>();
		
		ActionStd<PerbiorchInfo> enforcePortuguese = new ActionStdCommom<PerbiorchInfo>(option, PerbiorchVisiEnforcePt.class);
		ActionLazy<PerbiorchInfo> select = new ActionLazyCommom<PerbiorchInfo>(option, PerbiorchVisiRootSelect.class);
		
		enforcePortuguese.addPostAction(select);

		actions.add(enforcePortuguese);		
		return actions;
	}
}
