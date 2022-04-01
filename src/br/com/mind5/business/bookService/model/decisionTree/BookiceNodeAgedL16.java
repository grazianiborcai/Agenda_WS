package br.com.mind5.business.bookService.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.bookService.model.action.BookiceVisiEnforceAged;
import br.com.mind5.business.bookService.model.action.BookiceVisiEnforceSymsgL16;
import br.com.mind5.business.bookService.model.action.BookiceVisiMergeSymsg;
import br.com.mind5.business.bookService.model.checker.BookiceCheckSchederve;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class BookiceNodeAgedL16 extends DeciTreeTemplateWrite<BookiceInfo> {
	
	public BookiceNodeAgedL16(DeciTreeOption<BookiceInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<BookiceInfo> buildCheckerHook(DeciTreeOption<BookiceInfo> option) {
		List<ModelChecker<BookiceInfo>> queue = new ArrayList<>();		
		ModelChecker<BookiceInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;	
		checker = new BookiceCheckSchederve(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<BookiceInfo>> buildActionsOnPassedHook(DeciTreeOption<BookiceInfo> option) {
		List<ActionStd<BookiceInfo>> actions = new ArrayList<>();
		
		ActionStd<BookiceInfo> success = new ActionStdSuccessCommom<BookiceInfo>(option);	
		
		actions.add(success);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<BookiceInfo>> buildActionsOnFailedHook(DeciTreeOption<BookiceInfo> option) {
		List<ActionStd<BookiceInfo>> actions = new ArrayList<>();
		
		ActionStd<BookiceInfo> enforceSymsg = new ActionStdCommom<BookiceInfo>(option, BookiceVisiEnforceSymsgL16.class);	
		ActionLazy<BookiceInfo> mergeSymsg = new ActionLazyCommom<BookiceInfo>(option, BookiceVisiMergeSymsg.class);
		ActionLazy<BookiceInfo> enforceAged = new ActionLazyCommom<BookiceInfo>(option, BookiceVisiEnforceAged.class);
		
		enforceSymsg.addPostAction(mergeSymsg);
		mergeSymsg.addPostAction(enforceAged);
		
		actions.add(enforceSymsg);		
		return actions;
	}
}
