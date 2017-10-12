package newmod.common.entities;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import newmod.common.config.Reference;

public class Bee_Entity extends EntityMob
  {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MOD_ID, "entities/bee");

    public Bee_Entity(World worldIn)
      {
        super(worldIn);
        setSize(0.5F, 0.5F);
      }
    @Override
    protected void entityInit()
      {
        super.entityInit();
      }
    @Override
    protected void applyEntityAttributes()
      {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0.5D);
      }
    @Override
    protected void initEntityAI()
      {
        this.tasks.addTask(2, new Bee_Entity_AI(this, 1.0D, false));
        this.tasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWander(this, 2.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.applyEntityAI();
      }
    protected SoundEvent getAmbientSound()
      {
        return Sound_List.bee_Ambient;
      }
    protected SoundEvent getHurtSound(DamageSource damage)
      {
        return Sound_List.bee_Hurt;
      }
    protected SoundEvent getDeathSound()
      {
        return Sound_List.bee_Death;
      }
    protected SoundEvent getStepSound()
      {
        return Sound_List.bee_Step;
      }
    protected void playStepSound(BlockPos pos, Block blockIn)
      {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
      }
    private void applyEntityAI()
      {
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
      }
    @Override
    public boolean attackEntityAsMob(Entity entityIn)
      {
        if (super.attackEntityAsMob(entityIn))
          {
            if (entityIn instanceof EntityLivingBase)
              {
                // gives health boost and regeneration when it attacks
                //((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.HEALTH_BOOST, 200));
                //((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 200));
              }
            return true;
          }
        else
          {
            return false;
          }
      }
    @Override
    @Nullable
    protected ResourceLocation getLootTable()
      {
        return LOOT;
      }
    @Override
    protected boolean isValidLightLevel()
      {
        return true;
      }
    @Override
    public int getMaxSpawnedInChunk()
      {
        return 5;
      }
  }