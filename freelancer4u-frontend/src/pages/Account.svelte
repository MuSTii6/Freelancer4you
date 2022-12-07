<script>
    import { isAuthenticated, user } from "../store";
</script>

<h1>Account Details</h1>

{#if $isAuthenticated}
    <p><img src={$user.picture} alt="" srcset="" /></p>
    <p><b>Name:</b> {$user.name}</p>
    <p><b>Nickname:</b> {$user.nickname}</p>
    <p><b>Email:</b> {$user.email}</p>
{:else}
    <p>Not logged in</p>
{/if}
