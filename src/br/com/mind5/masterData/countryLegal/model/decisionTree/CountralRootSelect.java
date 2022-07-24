package br.com.mind5.masterData.countryLegal.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.countryLegal.info.CountralInfo;
import br.com.mind5.masterData.countryLegal.model.action.CountralVisiMergeCountry;
import br.com.mind5.masterData.countryLegal.model.action.CountralVisiMergeToSelect;
import br.com.mind5.masterData.countryLegal.model.checker.CountralCheckLangu;
import br.com.mind5.masterData.countryLegal.model.checker.CountralCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class CountralRootSelect extends DeciTreeTemplateRead<CountralInfo> {
	
	public CountralRootSelect(DeciTreeOption<CountralInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CountralInfo> buildCheckerHook(DeciTreeOption<CountralInfo> option) {
		List<ModelChecker<CountralInfo>> queue = new ArrayList<>();		
		ModelChecker<CountralInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CountralCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CountralCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CountralInfo>> buildActionsOnPassedHook(DeciTreeOption<CountralInfo> option) {
		List<ActionStd<CountralInfo>> actions = new ArrayList<>();
		
		ActionStd<CountralInfo> select = new ActionStdCommom<CountralInfo>(option, CountralVisiMergeToSelect.class);
		ActionLazy<CountralInfo> mergeCountry = new ActionLazyCommom<CountralInfo>(option, CountralVisiMergeCountry.class);
		
		select.addPostAction(mergeCountry);
		
		actions.add(select);
		return actions;
	}
}
