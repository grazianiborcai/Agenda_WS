package br.com.mind5.business.bookService.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.bookService.model.action.LazyBookiceNodeServiceL2;
import br.com.mind5.business.bookService.model.action.StdBookiceEnforceWeekday;
import br.com.mind5.business.bookService.model.checker.BookiceCheckLangu;
import br.com.mind5.business.bookService.model.checker.BookiceCheckOwner;
import br.com.mind5.business.bookService.model.checker.BookiceCheckService;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeBookiceServiceL1 extends DeciTreeTemplateWriteV2<BookiceInfo> {
	
	public NodeBookiceServiceL1(DeciTreeOption<BookiceInfo> option) {
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
		checker = new BookiceCheckService(checkerOption);
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
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<BookiceInfo>> buildActionsOnPassedHook(DeciTreeOption<BookiceInfo> option) {
		List<ActionStdV1<BookiceInfo>> actions = new ArrayList<>();
		
		ActionStdV1<BookiceInfo> enforceWeekday = new StdBookiceEnforceWeekday(option);
		ActionLazyV1<BookiceInfo> nodeL2 = new LazyBookiceNodeServiceL2(option.conn, option.schemaName);
		
		enforceWeekday.addPostAction(nodeL2);
		
		actions.add(enforceWeekday);
		return actions;
	}
}
