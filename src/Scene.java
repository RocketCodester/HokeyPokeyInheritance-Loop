import org.lgna.story.resources.biped.YetiBabyResource;
import org.lgna.story.event.SceneActivationEvent;
import org.lgna.story.event.SceneActivationListener;
import org.lgna.story.*;
import static org.lgna.common.ThreadUtilities.doTogether;

public class Scene extends SScene {

    public Scene() {
        super();
    }

    private void performCustomSetup() {
    }

    private void performGeneratedSetUp() {
        this.setAtmosphereColor(new Color(0.588, 0.886, 0.988));
        this.setFromAboveLightColor(Color.WHITE);
        this.setFromBelowLightColor(Color.BLACK);
        this.setFogDensity(0.0);
        this.setName("myScene");
        this.ground.setPaint(SGround.SurfaceAppearance.GRASS);
        this.ground.setOpacity(1.0);
        this.ground.setName("ground");
        this.ground.setVehicle(this);
        this.camera.setName("camera");
        this.camera.setVehicle(this);
        this.camera.setOrientationRelativeToVehicle(new Orientation(0.0, 0.995185, 0.0980144, 6.12323E-17));
        this.camera.setPositionRelativeToVehicle(new Position(9.61E-16, 1.56, -7.85));
        this.tortoise.setPaint(Color.WHITE);
        this.tortoise.setOpacity(1.0);
        this.tortoise.setName("tortoise");
        this.tortoise.setVehicle(this);
        this.tortoise.setOrientationRelativeToVehicle(new Orientation(0.0, 0.0, 0.0, 1.0));
        this.tortoise.setPositionRelativeToVehicle(new Position(-0.031, 0.0, -2.75));
        this.tortoise.setSize(new Size(0.691, 1.11, 0.51));
        this.tortoise2.setPaint(Color.WHITE);
        this.tortoise2.setOpacity(1.0);
        this.tortoise2.setName("tortoise2");
        this.tortoise2.setVehicle(this);
        this.tortoise2.setOrientationRelativeToVehicle(new Orientation(0.0, 0.0, 0.0, 1.0));
        this.tortoise2.setPositionRelativeToVehicle(new Position(-0.7, 0.0, -2.75));
        this.tortoise2.setSize(new Size(0.406, 0.651, 0.3));
        this.yetiBaby.setPaint(Color.WHITE);
        this.yetiBaby.setOpacity(1.0);
        this.yetiBaby.setName("yetiBaby");
        this.yetiBaby.setVehicle(this);
        this.yetiBaby.setOrientationRelativeToVehicle(new Orientation(0.0, 0.0, 0.0, 1.0));
        this.yetiBaby.setPositionRelativeToVehicle(new Position(-1.38, 0.0, -2.62));
        this.yetiBaby.setSize(new Size(0.461, 0.723, 0.387));
        this.alien.setPaint(Color.WHITE);
        this.alien.setOpacity(1.0);
        this.alien.setName("alien");
        this.alien.setVehicle(this);
        this.alien.setOrientationRelativeToVehicle(new Orientation(0.0, 0.0, 0.0, 1.0));
        this.alien.setPositionRelativeToVehicle(new Position(1.04, 0.0, -2.8));
        this.alien.setSize(new Size(0.566, 1.44, 0.578));
    }

    private void initializeEventListeners() {
        this.addSceneActivationListener(new SceneActivationListener() {
            @Override
            public void sceneActivated(final SceneActivationEvent e) {
                Scene.this.myFirstMethod();
            }
        });
    }

    @Override
    protected void handleActiveChanged(final Boolean isActive, final Integer activationCount) {
        if (isActive) {
            if (activationCount == 1) {
                this.performGeneratedSetUp();
                this.performCustomSetup();
                this.initializeEventListeners();
            } else {
                this.restoreStateAndEventListeners();
            }
        } else {
            this.preserveStateAndEventListeners();
        }
    }

    public void myFirstMethod() {
        this.delay(2.0);
        doTogether(new Runnable() {
            @Override
            public void run() {
                {
                    Scene.this.playAudio(new AudioSource(Resources.HokeyPokeySong_wav));
                    Scene.this.playAudio(new AudioSource(Resources.HokeyPokeySong_wav));
                }
            }
        }, new Runnable() {
            @Override
            public void run() {
                Scene.this.tortoise.hokeyPokey();
            }
        }, new Runnable() {
            @Override
            public void run() {
                Scene.this.tortoise2.hokeyPokey();
            }
        }, new Runnable() {
            @Override
            public void run() {
                Scene.this.yetiBaby.hokeyPokey();
            }
        }, new Runnable() {
            @Override
            public void run() {
                Scene.this.alien.hokeyPokey();
            }
        });
    }

    public SGround getGround() {
        return this.ground;
    }

    public SCamera getCamera() {
        return this.camera;
    }

    public Tortoise getTortoise() {
        return this.tortoise;
    }

    public Tortoise getTortoise2() {
        return this.tortoise2;
    }

    public YetiBaby getYetiBaby() {
        return this.yetiBaby;
    }

    public Alien getAlien() {
        return this.alien;
    }
    private final SGround ground = new SGround();
    private final SCamera camera = new SCamera();
    private final Tortoise tortoise = new Tortoise();
    private final Tortoise tortoise2 = new Tortoise();
    private final YetiBaby yetiBaby = new YetiBaby(YetiBabyResource.DEFAULT);
    private final Alien alien = new Alien();
}
