package br.com.mind5.business.personBioSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personBioSnapshot.info.PerbionapInfo;
import br.com.mind5.business.personBioSnapshot.model.action.PerbionapVisiMergeToSelect;
import br.com.mind5.business.personBioSnapshot.model.checker.PerbionapCheckLangu;
import br.com.mind5.business.personBioSnapshot.model.checker.PerbionapCheckOwner;
import br.com.mind5.business.personBioSnapshot.model.checker.PerbionapCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class PerbionapRootSelect extends DeciTreeTemplateWrite<PerbionapInfo> {
	
	public PerbionapRootSelect(DeciTreeOption<PerbionapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PerbionapInfo> buildCheckerHook(DeciTreeOption<PerbionapInfo> option) {
		List<ModelChecker<PerbionapInfo>> queue = new ArrayList<>();		
		ModelChecker<PerbionapInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PerbionapCheckRead(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PerbionapCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PerbionapCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PerbionapInfo>> buildActionsOnPassedHook(DeciTreeOption<PerbionapInfo> option) {
		List<ActionStd<PerbionapInfo>> actions = new ArrayList<>();
		
		ActionStd<PerbionapInfo> select = new ActionStdCommom<PerbionapInfo>(option, PerbionapVisiMergeToSelect.class);
		
		actions.add(select);
		return actions;
	}
}
