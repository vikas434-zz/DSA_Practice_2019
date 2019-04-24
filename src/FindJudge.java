import java.util.Objects;

public class FindJudge {

    public int findJudge(int N, int[][] trust) {
        // Create graph of N and then check degree, should be N-1
        final int NOT_FOUND = -1;
        final int trustArrayLength = trust.length;


        // Degree array should have value starting from 1 to N+1
        final int[] degreeArray = new int[N + 1];

        for (int i = 0; i < trustArrayLength; i++) {
            int[] itemInTrustArray = trust[i];

            // Since its outbound connection, decrease the degree by 1.
            degreeArray[itemInTrustArray[0]]--;

            // Since its inbound connection, increase the degree by 1.
            degreeArray[itemInTrustArray[1]]++;
        }

        // Now iterate though the degreeArray to find the index having degree as N-1.
        for (int i = 1; i <= N; i++) {
            if (degreeArray[i] == N - 1) {
                return i;
            }
        }
        return NOT_FOUND;
    }
}
