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
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootCalgueSelect extends DeciTreeTemplateWriteV2<CalgueInfo> {
	
	public RootCalgueSelect(DeciTreeOption<CalgueInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CalgueInfo> buildCheckerHook(DeciTreeOption<CalgueInfo> option) {
		List<ModelCheckerV1<CalgueInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CalgueInfo> checker;	
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
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CalgueInfo>> buildActionsOnPassedHook(DeciTreeOption<CalgueInfo> option) {
		List<ActionStdV1<CalgueInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<CalgueInfo> mergeCalguata = new StdCalgueMergeCalguata(option);
		ActionLazyV1<CalgueInfo> mergeCalatity = new LazyCalgueMergeCalatity(option.conn, option.schemaName);		
		ActionLazyV1<CalgueInfo> mergeMatlis = new LazyCalgueMergeMatlis(option.conn, option.schemaName);
		ActionLazyV1<CalgueInfo> mergeStolis = new LazyCalgueMergeStolis(option.conn, option.schemaName);
		ActionLazyV1<CalgueInfo> enforceAvailable = new LazyCalgueEnforceAvailable(option.conn, option.schemaName);
		
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
