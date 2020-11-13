package br.com.mind5.business.bookService.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.bookService.model.action.LazyBookiceMergeUsername;
import br.com.mind5.business.bookService.model.action.LazyBookiceNodeSchedineL2;
import br.com.mind5.business.bookService.model.action.StdBookiceEnforceWeekday;
import br.com.mind5.business.bookService.model.checker.BookiceCheckLangu;
import br.com.mind5.business.bookService.model.checker.BookiceCheckOwner;
import br.com.mind5.business.bookService.model.checker.BookiceCheckServiceSchedine;
import br.com.mind5.business.bookService.model.checker.BookiceCheckUsername;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeBookiceSchedineL1 extends DeciTreeTemplateWriteV2<BookiceInfo> {
	
	public NodeBookiceSchedineL1(DeciTreeOption<BookiceInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<BookiceInfo> buildCheckerHook(DeciTreeOption<BookiceInfo> option) {
		List<ModelCheckerV1<BookiceInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<BookiceInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new BookiceCheckServiceSchedine(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new BookiceCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new BookiceCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new BookiceCheckUsername(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<BookiceInfo>> buildActionsOnPassedHook(DeciTreeOption<BookiceInfo> option) {
		List<ActionStdV2<BookiceInfo>> actions = new ArrayList<>();
		
		ActionStdV2<BookiceInfo> enforceWeekday = new StdBookiceEnforceWeekday(option);
		ActionLazy<BookiceInfo> mergeUsername = new LazyBookiceMergeUsername(option.conn, option.schemaName);
		ActionLazy<BookiceInfo> nodeL2 = new LazyBookiceNodeSchedineL2(option.conn, option.schemaName);
		
		enforceWeekday.addPostAction(mergeUsername);
		mergeUsername.addPostAction(nodeL2);
		
		actions.add(enforceWeekday);
		return actions;
	}
}
