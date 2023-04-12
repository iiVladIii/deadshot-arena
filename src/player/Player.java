package player;

public class Player {
        private int health;
        private int damage;
        private int speed;
        private int endurance;
        private int firingRange;

        public Player() {
            this.health = 100;
            this.damage = 50;
            this.speed = 5;
            this.endurance = 10;
            this.firingRange = 100;
        }

        public Player(int health, int damage, int speed, int endurance, int firingRange) {
            this.health = health;
            this.damage = damage;
            this.speed = speed;
            this.endurance = endurance;
            this.firingRange = firingRange;
        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public int getDamage() {
            return damage;
        }

        public void setDamage(int damage) {
            this.damage = damage;
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public int getEndurance() {
            return endurance;
        }

        public void setEndurance(int endurance) {
            this.endurance = endurance;
        }

        public int getFiringRange() {
            return firingRange;
        }

        public void setFiringRange(int firingRange) {
            this.firingRange = firingRange;
        }

}
