package br.com.gda.file.fileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.file.fileImage.model.action.LazyFimgDelete;
import br.com.gda.file.fileImage.model.action.LazyFimgEnforceLChanged;
import br.com.gda.file.fileImage.model.action.LazyFimgMergeUsername;
import br.com.gda.file.fileImage.model.action.LazyFimgUpdate;
import br.com.gda.file.fileImage.model.action.StdFimgMergeToUpdate;
import br.com.gda.file.fileImage.model.checker.FimgCheckDelete;
import br.com.gda.file.fileImage.model.checker.FimgCheckExist;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootFimgDelete extends DeciTreeWriteTemplate<FimgInfo> {
	
	public RootFimgDelete(DeciTreeOption<FimgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimgInfo> buildDecisionCheckerHook(DeciTreeOption<FimgInfo> option) {
		List<ModelChecker<FimgInfo>> queue = new ArrayList<>();		
		ModelChecker<FimgInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FimgCheckDelete(checkerOption);
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new FimgCheckExist(checkerOption);
		queue.add(checker);	

		return new ModelCheckerQueue<FimgInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimgInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStd<FimgInfo>> actions = new ArrayList<>();
		
		ActionStd<FimgInfo> mergeToUpdate = new StdFimgMergeToUpdate(option);	
		ActionLazy<FimgInfo> enforceLChanged = new LazyFimgEnforceLChanged(option.conn, option.schemaName);	
		ActionLazy<FimgInfo> enforceLChangedBy = new LazyFimgMergeUsername(option.conn, option.schemaName);
		ActionLazy<FimgInfo> update = new LazyFimgUpdate(option.conn, option.schemaName);
		ActionLazy<FimgInfo> delete = new LazyFimgDelete(option.conn, option.schemaName);
		
		mergeToUpdate.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(delete);
		
		actions.add(mergeToUpdate);
		return actions;
	}
}
