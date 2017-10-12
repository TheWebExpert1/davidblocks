package newmod.common.entities;

import net.minecraft.entity.ai.EntityAIAttackMelee;

public class Bee_Entity_AI extends EntityAIAttackMelee
  {
    private Bee_Entity bee;

    public Bee_Entity_AI(Bee_Entity beeIn, double speedIn, boolean longMemoryIn)
      {
        super(beeIn, speedIn, longMemoryIn);
        this.bee = beeIn;
      }
    /**
     * Execute a one shot task or start executing a continuous task
     */
    @Override
    public void startExecuting()
      {
        super.startExecuting();
      }
    /**
     * Resets the task
     */
    @Override
    public void resetTask()
      {
        super.resetTask();
      }
    /**
     * Updates the task
     */
    @Override
    public void updateTask()
      {
        super.updateTask();
      }
  }