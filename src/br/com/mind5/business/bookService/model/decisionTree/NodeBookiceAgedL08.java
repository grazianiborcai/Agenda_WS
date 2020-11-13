package br.com.mind5.business.bookService.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.bookService.model.action.LazyBookiceEnforceAged;
import br.com.mind5.business.bookService.model.action.LazyBookiceMergeSymsg;
import br.com.mind5.business.bookService.model.action.StdBookiceEnforceSymsgL08;
import br.com.mind5.business.bookService.model.checker.BookiceCheckStoworg;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeBookiceAgedL08 extends DeciTreeTemplateWriteV2<BookiceInfo> {
	
	public NodeBookiceAgedL08(DeciTreeOption<BookiceInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<BookiceInfo> buildCheckerHook(DeciTreeOption<BookiceInfo> option) {
		List<ModelCheckerV1<BookiceInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<BookiceInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new BookiceCheckStoworg(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<BookiceInfo>> buildActionsOnPassedHook(DeciTreeOption<BookiceInfo> option) {
		List<ActionStdV2<BookiceInfo>> actions = new ArrayList<>();
		
		ActionStdV2<BookiceInfo> nodeL09 = new NodeBookiceAgedL09(option).toAction();	
		
		actions.add(nodeL09);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<BookiceInfo>> buildActionsOnFailedHook(DeciTreeOption<BookiceInfo> option) {
		List<ActionStdV2<BookiceInfo>> actions = new ArrayList<>();
		
		ActionStdV2<BookiceInfo> enforceSymsg = new StdBookiceEnforceSymsgL08(option);	
		ActionLazy<BookiceInfo> mergeSymsg = new LazyBookiceMergeSymsg(option.conn, option.schemaName);
		ActionLazy<BookiceInfo> enforceAged = new LazyBookiceEnforceAged(option.conn, option.schemaName);
		
		enforceSymsg.addPostAction(mergeSymsg);
		mergeSymsg.addPostAction(enforceAged);
		
		actions.add(enforceSymsg);		
		return actions;
	}
}
