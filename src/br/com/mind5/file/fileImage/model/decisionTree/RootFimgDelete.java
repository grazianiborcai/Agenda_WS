package br.com.mind5.file.fileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.model.action.LazyFimgDaoDelete;
import br.com.mind5.file.fileImage.model.action.LazyFimgEnforceLChanged;
import br.com.mind5.file.fileImage.model.action.LazyFimgMergeUsername;
import br.com.mind5.file.fileImage.model.action.LazyFimgDaoUpdate;
import br.com.mind5.file.fileImage.model.action.StdFimgMergeToUpdate;
import br.com.mind5.file.fileImage.model.checker.FimgCheckDelete;
import br.com.mind5.file.fileImage.model.checker.FimgCheckExist;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootFimgDelete extends DeciTreeTemplateWriteV2<FimgInfo> {
	
	public RootFimgDelete(DeciTreeOption<FimgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<FimgInfo> buildCheckerHook(DeciTreeOption<FimgInfo> option) {
		List<ModelCheckerV1<FimgInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<FimgInfo> checker;
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

		return new ModelCheckerHelperQueueV2<FimgInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<FimgInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStdV1<FimgInfo>> actions = new ArrayList<>();
		
		ActionStdV1<FimgInfo> mergeToUpdate = new StdFimgMergeToUpdate(option);	
		ActionLazyV1<FimgInfo> enforceLChanged = new LazyFimgEnforceLChanged(option.conn, option.schemaName);	
		ActionLazyV1<FimgInfo> enforceLChangedBy = new LazyFimgMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<FimgInfo> update = new LazyFimgDaoUpdate(option.conn, option.schemaName);
		ActionLazyV1<FimgInfo> delete = new LazyFimgDaoDelete(option.conn, option.schemaName);
		
		mergeToUpdate.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(delete);
		
		actions.add(mergeToUpdate);
		return actions;
	}
}
