package br.com.mind5.business.personBioSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personBioSearch.info.PerbiorchInfo;
import br.com.mind5.business.personBioSearch.model.action.LazyPerbiorchRootSelect;
import br.com.mind5.business.personBioSearch.model.action.StdPerbiorchEnforcePt;
import br.com.mind5.business.personBioSearch.model.checker.PerbiorchCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootPerbiorchSelectPt extends DeciTreeTemplateRead<PerbiorchInfo> {
	
	public RootPerbiorchSelectPt(DeciTreeOption<PerbiorchInfo> option) {
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
		
		ActionStd<PerbiorchInfo> enforcePortuguese = new StdPerbiorchEnforcePt(option);
		ActionLazy<PerbiorchInfo> select = new LazyPerbiorchRootSelect(option.conn, option.schemaName);
		
		enforcePortuguese.addPostAction(select);

		actions.add(enforcePortuguese);		
		return actions;
	}
}
