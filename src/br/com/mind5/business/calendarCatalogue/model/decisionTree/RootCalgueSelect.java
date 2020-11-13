package br.com.mind5.business.calendarCatalogue.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarCatalogue.info.CalgueInfo;
import br.com.mind5.business.calendarCatalogue.model.action.LazyCalgueEnforceAvailable;
import br.com.mind5.business.calendarCatalogue.model.action.LazyCalgueMergeCalatity;
import br.com.mind5.business.calendarCatalogue.model.action.LazyCalgueMergeMatlis;
import br.com.mind5.business.calendarCatalogue.model.action.LazyCalgueMergeStolis;
import br.com.mind5.business.calendarCatalogue.model.action.StdCalgueMergeCalguata;
import br.com.mind5.business.calendarCatalogue.model.checker.CalgueCheckLangu;
import br.com.mind5.business.calendarCatalogue.model.checker.CalgueCheckMat;
import br.com.mind5.business.calendarCatalogue.model.checker.CalgueCheckMonth;
import br.com.mind5.business.calendarCatalogue.model.checker.CalgueCheckOwner;
import br.com.mind5.business.calendarCatalogue.model.checker.CalgueCheckRead;
import br.com.mind5.business.calendarCatalogue.model.checker.CalgueCheckStore;
import br.com.mind5.business.calendarCatalogue.model.checker.CalgueCheckYearMonth;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootCalgueSelect extends DeciTreeTemplateWrite<CalgueInfo> {
	
	public RootCalgueSelect(DeciTreeOption<CalgueInfo> option) {
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
		
		ActionStd<CalgueInfo> mergeCalguata = new StdCalgueMergeCalguata(option);
		ActionLazy<CalgueInfo> mergeCalatity = new LazyCalgueMergeCalatity(option.conn, option.schemaName);		
		ActionLazy<CalgueInfo> mergeMatlis = new LazyCalgueMergeMatlis(option.conn, option.schemaName);
		ActionLazy<CalgueInfo> mergeStolis = new LazyCalgueMergeStolis(option.conn, option.schemaName);
		ActionLazy<CalgueInfo> enforceAvailable = new LazyCalgueEnforceAvailable(option.conn, option.schemaName);
		
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
