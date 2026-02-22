class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0]; // 시전 시간
        int x = bandage[1]; // 초당 회복량
        int y = bandage[2]; // 추가 회복량
        
        int currentHealth = health;
        int lastAttackTime = 0;
        
        for (int[] attack : attacks) {
            int attackTime = attack[0];
            int damage = attack[1];
            
            // 1. 공격받기 전까지의 체력 회복 계산 (공격받는 시간 제외)
            int timeDiff = attackTime - lastAttackTime - 1;
            int healAmount = (timeDiff * x) + ((timeDiff / t) * y);
            
            currentHealth += healAmount;
            
            // 최대 체력을 초과할 수 없음
            if (currentHealth > health) {
                currentHealth = health;
            }
            
            // 2. 몬스터의 공격 피해 적용
            currentHealth -= damage;
            
            // 체력이 0 이하가 되면 캐릭터 사망
            if (currentHealth <= 0) {
                return -1;
            }
            
            // 3. 마지막 공격 시간 갱신
            lastAttackTime = attackTime;
        }
        
        return currentHealth;
    }
}