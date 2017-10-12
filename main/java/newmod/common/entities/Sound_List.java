package newmod.common.entities;

import net.minecraft.init.Bootstrap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import newmod.common.config.Reference;

public class Sound_List
  {
	public static SoundEvent bee_Ambient;
	public static SoundEvent bee_Death;
	public static SoundEvent bee_Step;
	public static SoundEvent bee_Hurt;
	    
    public static void register(RegistryEvent.Register<SoundEvent> event)
      {
        bee_Ambient = register("Bee_Ambient");
        bee_Hurt = register("Bee_Hurt");
        bee_Death = register("Bee_Death");
        bee_Step = register("Bee_Step");
        event.getRegistry().registerAll(bee_Ambient, bee_Death, bee_Step, bee_Hurt);
      } 
    private static SoundEvent register(String name)
      {
        ResourceLocation sound = new ResourceLocation(Reference.MOD_ID, name);
        SoundEvent soundEvent = new SoundEvent(sound);
        soundEvent.setRegistryName(sound);
        return soundEvent;
      }
  }