package br.com.mind5.business.storeProspectSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeProspectSearch.info.StoprarchInfo;
import br.com.mind5.business.storeProspectSearch.model.action.StoprarchVisiMergeToSelect;
import br.com.mind5.business.storeProspectSearch.model.checker.StoprarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;


public final class StoprarchRootSelect extends DeciTreeTemplateRead<StoprarchInfo> {
	
	public StoprarchRootSelect(DeciTreeOption<StoprarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoprarchInfo> buildCheckerHook(DeciTreeOption<StoprarchInfo> option) {
		List<ModelChecker<StoprarchInfo>> queue = new ArrayList<>();		
		ModelChecker<StoprarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StoprarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoprarchInfo>> buildActionsOnPassedHook(DeciTreeOption<StoprarchInfo> option) {
		List<ActionStd<StoprarchInfo>> actions = new ArrayList<>();

		ActionStd<StoprarchInfo> select = new ActionStdCommom<StoprarchInfo>(option, StoprarchVisiMergeToSelect.class);
		
		actions.add(select);
		return actions;
	}
}
