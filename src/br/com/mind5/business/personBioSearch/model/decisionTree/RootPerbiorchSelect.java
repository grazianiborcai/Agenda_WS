package br.com.mind5.business.personBioSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personBioSearch.info.PerbiorchInfo;
import br.com.mind5.business.personBioSearch.model.action.StdPerbiorchMergeToSelect;
import br.com.mind5.business.personBioSearch.model.checker.PerbiorchCheckRead;
import br.com.mind5.business.personBioSearch.model.checker.PerbiorchCheckOwner;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootPerbiorchSelect extends DeciTreeTemplateRead<PerbiorchInfo> {
	
	public RootPerbiorchSelect(DeciTreeOption<PerbiorchInfo> option) {
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
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new PerbiorchCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PerbiorchInfo>> buildActionsOnPassedHook(DeciTreeOption<PerbiorchInfo> option) {
		List<ActionStd<PerbiorchInfo>> actions = new ArrayList<>();
		
		ActionStd<PerbiorchInfo> select = new StdPerbiorchMergeToSelect(option);

		actions.add(select);		
		return actions;
	}
}
