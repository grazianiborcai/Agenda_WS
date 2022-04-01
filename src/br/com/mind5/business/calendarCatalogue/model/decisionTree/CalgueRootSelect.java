package br.com.mind5.business.calendarCatalogue.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarCatalogue.info.CalgueInfo;
import br.com.mind5.business.calendarCatalogue.model.action.CalgueVisiEnforceAvailable;
import br.com.mind5.business.calendarCatalogue.model.action.CalgueVisiMergeCalatity;
import br.com.mind5.business.calendarCatalogue.model.action.CalgueVisiMergeCalguata;
import br.com.mind5.business.calendarCatalogue.model.action.CalgueVisiMergeMatlis;
import br.com.mind5.business.calendarCatalogue.model.action.CalgueVisiMergeStolis;
import br.com.mind5.business.calendarCatalogue.model.checker.CalgueCheckLangu;
import br.com.mind5.business.calendarCatalogue.model.checker.CalgueCheckMat;
import br.com.mind5.business.calendarCatalogue.model.checker.CalgueCheckMonth;
import br.com.mind5.business.calendarCatalogue.model.checker.CalgueCheckOwner;
import br.com.mind5.business.calendarCatalogue.model.checker.CalgueCheckRead;
import br.com.mind5.business.calendarCatalogue.model.checker.CalgueCheckStore;
import br.com.mind5.business.calendarCatalogue.model.checker.CalgueCheckYearMonth;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class CalgueRootSelect extends DeciTreeTemplateWrite<CalgueInfo> {
	
	public CalgueRootSelect(DeciTreeOption<CalgueInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CalgueInfo> buildCheckerHook(DeciTreeOption<CalgueInfo> option) {
		List<ModelChecker<CalgueInfo>> queue = new ArrayList<>();		
		ModelChecker<CalgueInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CalgueCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CalgueCheckYearMonth(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CalgueCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CalgueCheckMonth(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CalgueCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CalgueCheckMat(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CalgueCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CalgueInfo>> buildActionsOnPassedHook(DeciTreeOption<CalgueInfo> option) {
		List<ActionStd<CalgueInfo>> actions = new ArrayList<>();		
		
		ActionStd<CalgueInfo> mergeCalguata = new ActionStdCommom<CalgueInfo>(option, CalgueVisiMergeCalguata.class);
		ActionLazy<CalgueInfo> mergeCalatity = new  ActionLazyCommom<CalgueInfo>(option, CalgueVisiMergeCalatity.class);		
		ActionLazy<CalgueInfo> mergeMatlis = new ActionLazyCommom<CalgueInfo>(option, CalgueVisiMergeMatlis.class);
		ActionLazy<CalgueInfo> mergeStolis = new ActionLazyCommom<CalgueInfo>(option, CalgueVisiMergeStolis.class);
		ActionLazy<CalgueInfo> enforceAvailable = new ActionLazyCommom<CalgueInfo>(option, CalgueVisiEnforceAvailable.class);
		
		mergeCalguata.addPostAction(mergeCalatity);
		mergeCalatity.addPostAction(mergeMatlis);
		mergeMatlis.addPostAction(mergeStolis);
		mergeStolis.addPostAction(enforceAvailable);
		
		actions.add(mergeCalguata);			
		return actions;
	}
	
	
	
	@Override public void close() {
		super.close();
	}
}
